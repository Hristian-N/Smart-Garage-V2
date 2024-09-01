import Table from "../../components/Table";
import MyDrawer from "../../components/MyDrawer";
import Heading from "../../components/Heading";
import FilterSection from "../../components/FilterSection";
import { User } from "../../pages/Customer/Home";

export interface Vehicle {
  id: number;
  user: User;
  model: string;
  LicensePlate: string;
  VIN: string;
  creationYear: number;
  isDeleted: boolean;
}

function Vehicles() {
  // dummy data
  const columns = [
    "Id",
    "License Plate",
    "Brand",
    "Model",
    "Creation Year",
    "VIN",
    "Owner",
    "Details",
  ];
  const data = [
    {
      Id: 1,
      "License Plate": "A5077HH",
      Brand: "Mercedes-Benz",
      Model: "E270",
      "Creation Year": 2004,
      VIN: 12345678901234567,
      Owner: "John Atanasov",
      Details: "Details",
    },
    {
      Id: 2,
      "License Plate": "A1500HH",
      Brand: "BMW",
      Model: "i7",
      "Creation Year": 2010,
      VIN: 12345978941634567,
      Owner: "Maria Erikova",
      Details: "Details",
    },
    {
      Id: 3,
      "License Plate": "CA1234HH",
      Brand: "Fiat",
      Model: "Punto",
      "Creation Year": 2001,
      VIN: 12345978941634567,
      Owner: "Karina Boqnova",
      Details: "Details",
    },
  ];

  const selectElements = [
    "License Plate",
    "Brand",
    "Model",
    "Creation Year",
    "VIN",
    "Owner",
  ];

  return (
    <>
      <MyDrawer />
      <div className="m-5">
        <Heading>Vehicles</Heading>
        <FilterSection
          elements={selectElements}
          selectLabel={"Search By: "}
          showSearch={true}
        />

        <Table columns={columns} data={data} />
      </div>
    </>
  );
}

export default Vehicles;
