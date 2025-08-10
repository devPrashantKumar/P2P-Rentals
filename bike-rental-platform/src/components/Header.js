import { Card, CardBody } from "reactstrap";

function Header({ title }) {
    return (
        <div>
            <Card className="my-1 bg-warning">
                <CardBody>
                    <h1 className="text-center my-2">{title}</h1>
                </CardBody>
            </Card>
        </div>
    );
}

export default Header;
