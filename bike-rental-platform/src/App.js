import './App.css';
import Header from './components/Header';
import { Button, Col, Container, Row } from 'reactstrap'
import { ToastContainer, toast } from 'react-toastify';
import Home from './components/Home';
import Menus from './components/Menus';
import Allusers from './components/AllUsers';
import { BrowserRouter as Router, Route, Routes, } from 'react-router-dom';

function App() {
  const notify = () => toast("Wow so easy!");
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
                <Route path="/register" Component={Header} exact />
                <Route path="/all-users" Component={Allusers} exact />
                <Route path="/profile" Component={Allusers} exact />
              </Routes>
            </Col>
          </Row>
        </Container>
      </Router>
    </div>
  );
}

export default App;
