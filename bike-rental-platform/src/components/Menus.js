import { Link } from "react-router-dom";
import { ListGroup, ListGroupItem } from "reactstrap";

function Menus() {
    return (
        <div>
            <ListGroup>
                <Link className='list-group-item list-group-item-action' tag="a" to='/' action>Home</Link >
                <Link className='list-group-item list-group-item-action' tag="a" to='/register' action>Register New User</Link >
                <Link className='list-group-item list-group-item-action' tag="a" to='/profile' action>Profile</Link >
                <Link className='list-group-item list-group-item-action' tag="a" to='/all-users' action>All Users</Link >
                <Link className='list-group-item list-group-item-action' tag="a" to='#' action>Listed Bikes</Link >
                <Link className='list-group-item list-group-item-action' tag="a" to='#' action>Bookings</Link >
            </ListGroup>
        </div>
    );
}

export default Menus;
