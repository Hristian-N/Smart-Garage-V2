interface Props {
  elements: string[];
}

function Select({ elements }: Props) {
  return (
    <>
      <select
        className="form-select"
        style={{ width: "150px" }}
        aria-label="Default select example"
      >
        {elements.map((element, index) => (
          <option key={index}>{element}</option>
        ))}
      </select>
    </>
  );
}

export default Select;
