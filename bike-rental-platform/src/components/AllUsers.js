import { useEffect, useState } from "react";
import {
  all_users_url,
  disable_account_url,
  reactivate_account_url,
  update_user_url
} from "../api-urls";
import axios from "axios";
import {
  Table,
  Button,
  Modal,
  ModalHeader,
  ModalBody,
  ModalFooter,
  Form,
  FormGroup,
  Label,
  Input,
} from "reactstrap";

function Allusers() {
  const [users, setUsers] = useState([]);
  const [editModal, setEditModal] = useState(false);
  const [editUser, setEditUser] = useState({
    id: "",
    name: "",
    email: "",
    phone: "",
    isActive: true,
  });

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
      <h6>List of all Registered Users in Application</h6>
      <Table striped>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Active</th>
            <th>Created By</th>
            <th>Created At</th>
            <th>Updated By</th>
            <th>Updated At</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {users.length > 0 ? (
            users.map((user, index) => (
              <tr key={index}>
                <th scope="row">{user.id}</th>
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
                <td>{user.createdBy}</td>
                <td>{user.createdAt}</td>
                <td>{user.updatedBy}</td>
                <td>{user.updatedAt}</td>
                <td>
                  <Button
                    color="primary"
                    size="sm"
                    className="me-2"
                    onClick={() => handleUpdate(user)}
                  >
                    Update
                  </Button>
                </td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="10" className="text-center">
                No users found
              </td>
            </tr>
          )}
        </tbody>
      </Table>

      {/* Edit User Modal */}
      <Modal isOpen={editModal} toggle={() => setEditModal(!editModal)}>
        <ModalHeader toggle={() => setEditModal(!editModal)}>
          Edit User
        </ModalHeader>
        <ModalBody>
          <Form>
            <FormGroup>
              <Label for="name">Name</Label>
              <Input
                id="name"
                name="name"
                value={editUser.name}
                onChange={handleEditChange}
              />
            </FormGroup>
            <FormGroup>
              <Label for="email">Email</Label>
              <Input
                id="email"
                name="email"
                type="email"
                value={editUser.email}
                onChange={handleEditChange}
              />
            </FormGroup>
            <FormGroup>
              <Label for="phone">Phone</Label>
              <Input
                id="phone"
                name="phone"
                value={editUser.phone}
                onChange={handleEditChange}
              />
            </FormGroup>
          </Form>
        </ModalBody>
        <ModalFooter>
          <Button color="primary" onClick={handleEditSave}>
            Save
          </Button>{" "}
          <Button color="secondary" onClick={() => setEditModal(false)}>
            Cancel
          </Button>
        </ModalFooter>
      </Modal>
    </div>
  );
}

export default Allusers;
