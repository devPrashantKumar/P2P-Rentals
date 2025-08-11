import { Card, CardBody } from "reactstrap";
import axios from "axios";
import { useEffect, useState } from "react";

function Health({ name, healthCheckUrl }) {
  const [healthMsg, setHealthMsg] = useState("");
  const [status, setStatus] = useState("loading");

  useEffect(() => {
    getHealth();
    // You could also poll periodically with setInterval if needed
  }, []);

  const getHealth = () => {
    axios
      .get(healthCheckUrl)
      .then((response) => {
        //console.error(response);
        const data = response.data || "";
        setHealthMsg(typeof data === "string" ? data : JSON.stringify(data));
        setStatus("up");
      })
      .catch((error) => {
        console.error("Error fetching health status:", error);
        setHealthMsg("Error fetching health status");
        setStatus("error");
      });
  };

  const getCardColor = () => {
    switch (status) {
      case "up":
        return "bg-success text-white";
      case "down":
        return "bg-danger text-white";
      case "error":
        return "bg-secondary text-white";
      default:
        return "bg-warning text-dark";
    }
  };

  return (
    <div>
      <Card className={`my-1 ${getCardColor()}`}>
        <CardBody className="text-center">
          <h3>{name}</h3>
          <p className="m-0">{healthMsg}</p>
        </CardBody>
      </Card>
    </div>
  );
}

export default Health;
