interface Props {
  columns: string[];
  data: Array<{ [key: string]: any }>;
}

const columnDisplayNames: { [key: string]: string } = {
  id: "Id",
  licensePlate: "License Plate",
  model: "Model",
  creationYear: "Creation Year",
  vin: "VIN",
  brand: "Brand",
  owner: "Owner",
  date: "Date",
  price: "Price",
  details: "Details",
  quantity: "Quantity",
  unitPrice: "Unit Price",
};

function Table({ columns, data }: Props) {
  return (
    <>
      <div className="table-responsive small">
        <table className="table table-striped table-sm">
          <thead>
            <tr>
              {columns.map((column) => (
                <th scope="col" key={column}>
                  {columnDisplayNames[column] || column}
                </th>
              ))}
            </tr>
          </thead>
          <tbody>
            {data.map((row, rowIndex) => (
              <tr key={rowIndex}>
                {columns.map((column, columnIndex) => (
                  <td key={columnIndex}>{row[column]}</td>
                ))}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
}

export default Table;
