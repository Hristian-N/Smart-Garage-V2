interface Props {
  label: string;
  id: string;
  width: number;
}

function Input({ label, id, width }: Props) {
  return (
    <>
      <div className={"col-sm-" + width}>
        <label htmlFor={id} className="form-label">
          {label}
        </label>
        <input type="text" className="form-control" id={id} required />
        <div className="invalid-feedback">Valid {label} is required.</div>
      </div>
    </>
  );
}

export default Input;
