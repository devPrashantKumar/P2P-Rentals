import './App.css';
import Header from './components/Header';
import { Button, Col, Container, Row } from 'reactstrap'
import { ToastContainer, toast } from 'react-toastify';
import Home from './components/Home';
import Menus from './components/Menus';

function App() {
  const notify = () => toast("Wow so easy!");
  return (
    <div>
      <ToastContainer />
      <Header title="P2P Bike Rental Platform" />
      <Container>
        <Row>
          <Col md={4}>
            <Menus />
          </Col>
          <Col md={8}>
            <Home />
          </Col>
        </Row>
      </Container>


      {/* <Header title="Card 1"/>
      <Home/>
      <h1>Bike Rental Platform</h1>
      <Button color='primary' onClick={notify}>First Button</Button> */}
    </div>
  );
}

export default App;
