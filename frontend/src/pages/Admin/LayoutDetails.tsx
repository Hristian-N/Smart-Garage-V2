import ListGroup from "../../components/ListGroup";

function LayoutDetails() {
  const headings = ["Id", "Name", "Email", "Phone Number", "Is Admin"];
  const data = ["1", "John Atansov", "john@gmail.com", "123456789", "Yes"];

  return (
    <>
      <ListGroup heading={headings} data={data} />
    </>
  );
}

export default LayoutDetails;
