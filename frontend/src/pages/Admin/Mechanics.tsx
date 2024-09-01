import Table from "../../components/Table";
import MyDrawer from "../../components/MyDrawer";
import Heading from "../../components/Heading";
import FilterSection from "../../components/FilterSection";

function Mechanics() {
  // dummy data
  const columns = ["Id", "Name", "Email", "Phone Number", "Details"];
  const data = [
    {
      Id: 1,
      Name: "John Atanasov",
      Email: "john@gmail.com",
      "Phone Number": "0123456789",
      Details: "Details",
    },
    {
      Id: 2,
      Name: "Maria Stoqnova",
      Email: "maria@gmail.com",
      "Phone Number": "4567899046",
      Details: "Details",
    },
    {
      Id: 3,
      Name: "Karina Boqnova",
      Email: "Karina@gmail.com",
      "Phone Number": "0987654321",
      Details: "Details",
    },
  ];

  const selectElements = ["Name", "Email", "Phone Number"];

  return (
    <>
      <MyDrawer />
      <div className="m-5">
        <Heading>Mechanics</Heading>
        <FilterSection elements={selectElements} showSearch={true} />

        <Table columns={columns} data={data} />
      </div>
    </>
  );
}

export default Mechanics;
