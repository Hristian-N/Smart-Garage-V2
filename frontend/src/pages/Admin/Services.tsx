import Table from "../../components/Table";
import MyDrawer from "../../components/MyDrawer";
import Heading from "../../components/Heading";
import FilterSection from "../../components/FilterSection";

function Services() {
  // dummy data
  const columns = ["Id", "Owner", "Email", "Phone Number", "Details"];
  const data = [
    {
      Id: 1,
      Owner: "John Atanasov",
      Email: "john@gmail.com",
      "Phone Number": "0123456789",
      Details: "Details",
    },
    {
      Id: 2,
      Owner: "Maria Stoqnova",
      Email: "maria@gmail.com",
      "Phone Number": "4567899046",
      Details: "Details",
    },
    {
      Id: 3,
      Owner: "Karina Boqnova",
      Email: "Karina@gmail.com",
      "Phone Number": "0987654321",
      Details: "Details",
    },
  ];

  const selectElements = ["Owner", "Email", "Phone Number"];

  return (
    <>
      <MyDrawer />
      <div className="m-5">
        <Heading>Services</Heading>
        <FilterSection
          elements={selectElements}
          showSearch={true}
          showSlider={true}
        />

        <Table columns={columns} data={data} />
      </div>
    </>
  );
}

export default Services;
