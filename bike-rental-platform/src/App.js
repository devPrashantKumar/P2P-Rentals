import './App.css';
import Header from './components/Header';
import { Col, Container, Row } from 'reactstrap'
import { ToastContainer } from 'react-toastify';
import Home from './components/Home';
import Menus from './components/Menus';
import Allusers from './components/AllUsers';
import Profile from './components/Profile';
import RegisterUser from './components/RegisterUser';
import { BrowserRouter as Router, Route, Routes, } from 'react-router-dom';

function App() {
  return (
    <div>
      <Router>
        <ToastContainer />
        <Header title="P2P Bike Rental Platform" />
        <Container>
          <Row>
            <Col md={4}>
              <Menus />
            </Col>
            <Col md={8}>
              <Routes>
                <Route path="/" Component={Home} exact />
                <Route path="/register" Component={RegisterUser} exact />
                <Route path="/all-users" Component={Allusers} exact />
                <Route path="/profile" Component={Profile} exact />
              </Routes>
            </Col>
          </Row>
        </Container>
      </Router>
    </div>
  );
}

export default App;
