import { useState } from "react";
import { Button, Form, FormGroup, Label, Input, Container } from "reactstrap";
import axios from "axios";
import { register_user_url } from "../api-urls";

function RegisterUser() {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    phone: "",
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios
      .post(register_user_url, formData)
      .then(() => {
        alert("User registered successfully!");
        setFormData({ name: "", email: "", phone: "" });
      })
      .catch((error) => {
        console.error("Error registering user:", error);
        alert("Registration failed. Please try again.");
      });
  };

  const handleCancel = () => {
    // Clear form fields
    setFormData({ name: "", email: "", phone: "" });
  };

  return (
    <Container className="mt-4">
      <h1>Register User</h1>
      <Form onSubmit={handleSubmit}>
        <FormGroup>
          <Label for="name">Full Name</Label>
          <Input
            id="name"
            name="name"
            value={formData.name}
            onChange={handleChange}
            placeholder="Enter your full name"
            required
          />
        </FormGroup>

        <FormGroup>
          <Label for="email">Email Address</Label>
          <Input
            id="email"
            name="email"
            type="email"
            value={formData.email}
            onChange={handleChange}
            placeholder="Enter your email"
            required
          />
        </FormGroup>

        <FormGroup>
          <Label for="phone">Phone Number</Label>
          <Input
            id="phone"
            name="phone"
            value={formData.phone}
            onChange={handleChange}
            placeholder="Enter your phone number"
            required
          />
        </FormGroup>

        <div className="d-flex gap-2">
          <Button color="primary" type="submit">
            Register
          </Button>
          <Button color="secondary" type="button" onClick={handleCancel}>
            Cancel
          </Button>
        </div>
      </Form>
    </Container>
  );
}

export default RegisterUser;
