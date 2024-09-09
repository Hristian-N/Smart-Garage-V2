interface Props {
  label: string;
  id: string;
  width: number;
  value?: string;
  disabled?: boolean;
}

function Input({ label, id, width, value, disabled = false }: Props) {
  return (
    <>
      <div className={"col-sm-" + width}>
        <label htmlFor={id} className="form-label">
          {label}
        </label>
        <input
          type="text"
          className="form-control"
          id={id}
          disabled={disabled}
          value={value || ""}
        />
        <div className="invalid-feedback">Valid {label} is required.</div>
      </div>
    </>
  );
}

export default Input;
