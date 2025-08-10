import { useEffect, useState } from "react";
import {
  all_users_url,
  disable_account_url,
  reactivate_account_url,
  update_user_url
} from "../api-urls";
import axios from "axios";
import { Table, Button } from "reactstrap";
import UserEditModal from "./UserEditModal"; // ✅ import reusable modal

function Allusers() {
  const [users, setUsers] = useState([]);
  const [editModal, setEditModal] = useState(false);
  const [editUser, setEditUser] = useState({});

  useEffect(() => {
    document.title = "All Users";
    getAllUsers();
  }, []);

  const getAllUsers = () => {
    axios
      .get(all_users_url)
      .then((response) => {
        setUsers(response.data.responseData || []);
      })
      .catch((error) => {
        console.error("Error fetching users:", error);
      });
  };

  const handleUpdate = (user) => {
    setEditUser(user);
    setEditModal(true);
  };

  const handleDelete = (id) => {
    if (window.confirm("Are you sure you want to delete this user?")) {
      axios
        .delete(`${disable_account_url}/${id}`)
        .then(() => {
          alert("User deleted successfully");
          getAllUsers();
        })
        .catch((error) => {
          console.error("Error deleting user:", error);
          alert("Failed to delete user");
        });
    }
  };

  const handleReactivate = (id) => {
    if (window.confirm("Are you sure you want to reactivate this user?")) {
      axios
        .patch(`${reactivate_account_url}/${id}`)
        .then(() => {
          alert("User reactivated successfully");
          getAllUsers();
        })
        .catch((error) => {
          console.error("Error reactivating user:", error);
          alert("Failed to reactivate user");
        });
    }
  };

  const handleEditChange = (e) => {
    setEditUser({ ...editUser, [e.target.name]: e.target.value });
  };

  const handleEditSave = () => {
    axios
      .put(`${update_user_url}/${editUser.id}`, editUser)
      .then(() => {
        alert("User updated successfully");
        setEditModal(false);
        getAllUsers();
      })
      .catch((error) => {
        console.error("Error updating user:", error);
        alert("Failed to update user");
      });
  };

  return (
    <div>
      <h3>All Users</h3>
      <Table striped>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Active</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {users.length > 0 ? (
            users.map((user) => (
              <tr key={user.id}>
                <td>{user.id}</td>
                <td>{user.name}</td>
                <td>{user.email}</td>
                <td>{user.phone}</td>
                <td>
                  {user.isActive ? (
                    <Button
                      color="danger"
                      size="sm"
                      onClick={() => handleDelete(user.id)}
                    >
                      Delete
                    </Button>
                  ) : (
                    <Button
                      color="warning"
                      size="sm"
                      onClick={() => handleReactivate(user.id)}
                    >
                      Reactivate
                    </Button>
                  )}
                </td>
                <td>
                  <Button
                    color="primary"
                    size="sm"
                    onClick={() => handleUpdate(user)}
                  >
                    Update
                  </Button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="6" className="text-center">
                No users found
              </td>
            </tr>
          )}
        </tbody>
      </Table>

      {/* Reusable Edit Modal */}
      <UserEditModal
        isOpen={editModal}
        toggle={() => setEditModal(!editModal)}
        userData={editUser}
        onChange={handleEditChange}
        onSave={handleEditSave}
      />
    </div>
  );
}

export default Allusers;
