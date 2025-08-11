import Health from "./Health";
import { bikes_microservice_health_url, bookings_microservice_health_url, notifications_microservice_health_url, payments_microservice_health_url, users_microservice_health_url } from "../api-urls";

function MicroserviceHealth() {
    return (
        <div>
            <Health name="BikesMicroservice" healthCheckUrl={bikes_microservice_health_url} />
            <Health name="BookingsMicroservice" healthCheckUrl={bookings_microservice_health_url} />
            <Health name="NotificationsMicroservice" healthCheckUrl={notifications_microservice_health_url} />
            <Health name="PaymentsMicroservice" healthCheckUrl={payments_microservice_health_url} />
            <Health name="UsersMicroservice" healthCheckUrl={users_microservice_health_url} />
        </div>
    );
}

export default MicroserviceHealth;
