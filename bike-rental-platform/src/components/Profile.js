import { useEffect, useState } from "react";
import {
    get_user_url
} from "../api-urls";
import axios from "axios";
import { CardBody, Card, CardTitle, CardSubtitle, CardText, Button } from "reactstrap"
function Profile() {
    const [user, setUser] = useState({});
    useEffect(() => {
        document.title = "User Profile";
        getUserDetails("f2c14173-157a-437b-9c41-39346c750fcc");
    }, []);

    const getUserDetails = (id) => {
        axios
            .get(`${get_user_url}/${id}`)
            .then((response) => {
                setUser(response.data.responseData || {});
            })
            .catch((error) => {
                console.error("Error fetching users:", error);
            });
    };

    return (
        <div>
            <h3>My Profile</h3>
            <Card>
                <CardBody>
                    <CardTitle tag="h5">
                        Name : {user.name}
                    </CardTitle>
                    <CardTitle tag="h5">
                        Email : {user.email}
                    </CardTitle>
                    <CardTitle tag="h5">
                        Phone No. : {user.phone}
                    </CardTitle>
                    <Button
                        color="primary"
                        size="sm"
                        className="me-2"
                        //onClick={() => handleUpdate(user)}
                    >
                        Update
                    </Button>
                </CardBody>
            </Card>
        </div>
    );
}

export default Profile;
