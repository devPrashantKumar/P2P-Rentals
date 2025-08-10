import React from "react";
import { Container, Row, Col, Button } from "reactstrap";
import { useNavigate } from "react-router-dom";

function Home() {
  const navigate = useNavigate();

  return (
    <Container className="mt-5">
      {/* Hero Section */}
      <Row className="align-items-center">
        <Col md="6">
          <h3 className="display-4 fw-bold">P2P Bike Rental Platform</h3>
          <p className="lead">
            Rent a bike from people near you or list your own bike to earn money.
            A convenient, secure, and eco-friendly way to travel.
          </p>
          <div className="mt-4">
            <Button
              color="primary"
              size="lg"
              className="me-3"
              onClick={() => navigate("/rent-bike")}
            >
              Rent a Bike
            </Button>
            <Button
              color="success"
              size="lg"
              onClick={() => navigate("/list-bike")}
            >
              List Your Bike
            </Button>
          </div>
        </Col>

        {/* Right side image */}
        <Col md="6" className="text-center">
          <img
            src="/Home_image.jpg"
            alt="Bike Rental"
            className="img-fluid rounded shadow"
          />
        </Col>
      </Row>

      {/* Features Section */}
      <Row className="mt-5 text-center">
        <Col md="4">
          <h4>🚲 Easy Rentals</h4>
          <p>Book a bike in minutes from verified owners near you.</p>
        </Col>
        <Col md="4">
          <h4>💰 Earn Extra</h4>
          <p>List your bike when you're not using it and earn money.</p>
        </Col>
        <Col md="4">
          <h4>🌱 Eco-Friendly</h4>
          <p>Reduce your carbon footprint by sharing rides.</p>
        </Col>
      </Row>
    </Container>
  );
}

export default Home;
