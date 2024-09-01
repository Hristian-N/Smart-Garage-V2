interface Props {
  heading: string[];
  data: string[];
}

function ListGroup({ heading, data }: Props) {
  return (
    <>
      <div className="list-group">
        {heading.map((element, index) => (
          <div
            className="list-group-item py-3"
            style={{ width: "30vw" }}
            aria-current="true"
            key={index}
          >
            <div className="row">
              <div className="col-5 fw-bold">{element}</div>
              <div className="col-5">{data[index]}</div>
              <button
                type="button"
                className="btn btn-icon col-1 d-flex justify-content-center align-items-center"
              >
                <span className="material-symbols-outlined">edit</span>
              </button>

              <div className="col-1"></div>
            </div>
          </div>
        ))}
      </div>
    </>
  );
}

export default ListGroup;
