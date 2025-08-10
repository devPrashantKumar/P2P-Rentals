import { useEffect, useState } from "react";
import { get_user_url, update_user_url } from "../api-urls";
import axios from "axios";
import { Card, CardBody, CardTitle, Button } from "reactstrap";
import UserEditModal from "./UserEditModal"; // ✅ reusable modal

function Profile() {
  const [user, setUser] = useState({});
  const [editModal, setEditModal] = useState(false);
  const [editUser, setEditUser] = useState({});

  useEffect(() => {
    document.title = "User Profile";
    getUserDetails("f2c14173-157a-437b-9c41-39346c750fcc"); // demo user ID
  }, []);

  const getUserDetails = (id) => {
    axios
      .get(`${get_user_url}/${id}`)
      .then((response) => {
        const data = response.data.responseData || {};
        setUser(data);
        setEditUser(data);
      })
      .catch((error) => {
        console.error("Error fetching user:", error);
      });
  };

  const handleEditChange = (e) => {
    setEditUser({ ...editUser, [e.target.name]: e.target.value });
  };

  const handleEditSave = () => {
    axios
      .put(`${update_user_url}/${editUser.id}`, editUser)
      .then(() => {
        alert("Profile updated successfully");
        setUser(editUser);
        setEditModal(false);
      })
      .catch((error) => {
        console.error("Error updating profile:", error);
        alert("Failed to update profile");
      });
  };

  return (
    <div>
      <h3>My Profile</h3>
      <Card>
        <CardBody>
          <CardTitle tag="h5">Name: {user.name}</CardTitle>
          <CardTitle tag="h5">Email: {user.email}</CardTitle>
          <CardTitle tag="h5">Phone No.: {user.phone}</CardTitle>
          <Button color="primary" size="sm" onClick={() => setEditModal(true)}>
            Update
          </Button>
        </CardBody>
      </Card>

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

export default Profile;
