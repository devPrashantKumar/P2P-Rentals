import { useEffect, useState } from "react";
import { all_users_url } from "../api-urls";
import axios from "axios";
import { Table } from "reactstrap";

function Allusers() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    document.title = "All Users";
    getAllUsers();
  }, []);

  const getAllUsers = () => {
    axios
      .get(all_users_url)
      .then((response) => {
        console.log(response);
        setUsers(response.data.responseData || []);
      })
      .catch((error) => {
        console.error("Error fetching users:", error);
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
            <th>Phone</th>
            <th>Email</th>
            <th>Active</th>
          </tr>
        </thead>
        <tbody>
          {users.length > 0 ? (
            users.map((user, index) => (
              <tr key={index}>
                <th scope="row">{user.id}</th>
                <td>{user.name}</td>
                <td>{user.phone}</td>
                <td>{user.email}</td>
                <td>{user.isActive ? "Active" : "Inactive"}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="4" className="text-center">
                No users found
              </td>
            </tr>
          )}
        </tbody>
      </Table>
    </div>
  );
}

export default Allusers;
