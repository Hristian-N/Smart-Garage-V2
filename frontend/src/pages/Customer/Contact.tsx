import PageTitle from "../../components/Heading";
import Layout from "../Layout";
import Table from "../../components/Table";

function Contact() {
  const columns = ["Name", "Age", "Email"];
  const data = [
    { Name: "John Doe", Age: 28, Email: "john@example.com" },
    { Name: "Jane Smith", Age: 34, Email: "jane@example.com" },
    { Name: "Sam Green", Age: 22, Email: "sam@example.com" },
  ];

  return (
    <Layout>
      <PageTitle>Contact Us</PageTitle>
      <Table columns={columns} data={data} />
    </Layout>
  );
}

export default Contact;
