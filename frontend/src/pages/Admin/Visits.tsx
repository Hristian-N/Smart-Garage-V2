import Table from "../../components/Table";
import Heading from "../../components/Heading";
import MyDrawer from "../../components/MyDrawer";
import FilterSection from "../../components/FilterSection";

function Visits() {
  // dummy data
  const columns = [
    "Id",
    "License Plate",
    "Brand",
    "Model",
    "Owner",
    "Date",
    "Price",
    "Details",
  ];
  const data = [
    {
      Id: 1,
      "License Plate": "A5077HH",
      Brand: "Mercedes-Benz",
      Model: "E270",
      Owner: "John Atanasov",
      Date: "28.07.2024",
      Price: 124.0,
      Details: "Details",
    },
    {
      Id: 2,
      "License Plate": "A5077HH",
      Brand: "Mercedes-Benz",
      Model: "E270",
      Owner: "Maria Stoqnova",
      Date: "20.06.2024",
      Price: 741.0,
      Details: "Details",
    },
    {
      Id: 3,
      "License Plate": "CA1234HH",
      Brand: "Fiat",
      Model: "Punto",
      Owner: "Karina Boqnova",
      Date: "19.05.2024",
      Price: 123.0,
      Details: "Details",
    },
  ];

  const selectElements = ["Username", "Owner", "Email", "Phone Number"];

  return (
    <>
      <MyDrawer />
      <div className="m-5">
        <Heading>Visits</Heading>
        <FilterSection
          elements={selectElements}
          selectLabel={"Search By: "}
          showSearch={true}
          showDates={true}
        />

        <Table columns={columns} data={data} />
      </div>
    </>
  );
}

export default Visits;
