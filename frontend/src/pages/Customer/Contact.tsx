import PageTitle from "../../components/Heading";
import Layout from "../Layout";
import Heading from "../../components/Heading";
import Table from "../../components/Table";
import { APIProvider, Map } from "@vis.gl/react-google-maps";

function Contact() {
  return (
    <Layout>
      <Heading>Contact Us</Heading>
      <div className="container my-5">
        <div className="row">
          <div className="col-md-6">
            <p>Have questions or inquiries? Reach out to us!</p>
            <p>
              <strong>The Smart-Garage Company</strong>
            </p>
            <p>
              <i className="bi bi-house-door"></i> Address: 1000 Sofia 2
              "Dondukov" Blvd
              <br />
              <i className="bi bi-envelope"></i> Email: smart-garage@gmail.com
              <br />
              <i className="bi bi-telephone"></i> Phone: +359 123-456
            </p>
          </div>
          <div className="col-md-6">
            <div className="ratio ratio-16x9">
              <APIProvider
                apiKey={import.meta.env.GOOGLE_MAPS_API_KEY || "Not working"}
              >
                <Map
                  style={{ width: "20vw", height: "20vh" }}
                  defaultCenter={{ lat: 22.54992, lng: 0 }}
                  defaultZoom={3}
                  gestureHandling={"greedy"}
                  disableDefaultUI={true}
                />
              </APIProvider>
            </div>
          </div>
        </div>
      </div>
    </Layout>
  );
}

export default Contact;
