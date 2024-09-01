import Heading from "../../components/Heading";
import Layout from "../Layout";
import Input from "../../components/Input";
import Table from "../..//components/Table";

function Detail() {
  // Dummy Data
  const columnsParts = ["Name", "Quantity", "Unit Price", "Final Price"];
  const dataParts = [
    { Name: "Oil Filter", Quantity: 1, "Unit Price": 30, "Final Price": 30 },
    { Name: "Oil", Quantity: 5, "Unit Price": 15, "Final Price": 75 },
    { Name: "Air Filter", Quantity: 1, "Unit Price": 40, "Final Price": 40 },
  ];

  const columnService = ["Name", "Mechanic", "Price"];
  const dataService = [
    { Name: "Change Oil Filter", Mechanic: "Leonardo Dicaprio", Price: 10 },
    { Name: "Change Oil", Mechanic: "Bruce Lee", Price: 10 },
    { Name: "Change Air Filter", Mechanic: "Brat Pitt", Price: 10 },
  ];

  return (
    <Layout>
      <Heading>Detail</Heading>
      <div style={{ marginLeft: "10rem", marginRight: "10rem" }}>
        <form className="needs-validation mt-5">
          <div className="row g-3">
            <div className="row g-3">
              <h4>Customer</h4>
              <Input label="First Name" id="firstName" width={3}></Input>
              <Input label="Last Name" id="lastName" width={3}></Input>
              <Input label="Email" id="email" width={3}></Input>
              <Input label="Phone Number" id="phoneNumber" width={3}></Input>
            </div>
            <div className="row g-3 mt-5">
              <h4>Vehicle</h4>
              <Input label="License Plate" id="licansePlate" width={3}></Input>
              <Input label="Brand" id="brand" width={3}></Input>
              <Input label="Model" id="model" width={3}></Input>
              <Input label="Creation Year" id="year" width={3}></Input>
              <Input label="VIN" id="vin" width={6}></Input>
              <Input label="kW" id="kw" width={3}></Input>
            </div>
          </div>
        </form>

        <h4 className="mt-5">Parts</h4>
        <Table columns={columnsParts} data={dataParts}></Table>
        <div className="d-flex justify-content-between align-items-center mt-3">
          <button className="btn btn-primary rounded-pill px-3" type="button">
            Add Part
          </button>
          <p className="mb-0">Total Parts Price: 100</p>
        </div>

        <h4 className="mt-5">Service</h4>
        <Table columns={columnService} data={dataService}></Table>
        <div className="d-flex justify-content-between align-items-center mt-3">
          <button className="btn btn-primary rounded-pill px-3" type="button">
            Add Service
          </button>
          <p className="mb-0">Total Service Price: 100</p>
        </div>

        <div className="d-flex justify-content-center">
          <p className="mt-5 mb-5">Total Price: 200</p>
        </div>
      </div>
    </Layout>
  );
}

export default Detail;
