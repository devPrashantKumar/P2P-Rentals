import { ListGroup, ListGroupItem } from "reactstrap";

function Menus() {
    return (
        <div>
            <ListGroup>
                <ListGroupItem tag="a" href='#' action>Home</ListGroupItem>
                <ListGroupItem tag="a" href='#' action>Register New User</ListGroupItem>
                <ListGroupItem tag="a" href='#' action>Profile</ListGroupItem>
                <ListGroupItem tag="a" href='#' action>All Users</ListGroupItem>
                <ListGroupItem tag="a" href='#' action>Listed Bikes</ListGroupItem>
                <ListGroupItem tag="a" href='#' action>Bookings</ListGroupItem>
            </ListGroup>
        </div>
    );
}

export default Menus;
