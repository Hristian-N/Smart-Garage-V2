interface Props {
  children: string;
}

function Heading({ children }: Props) {
  return (
    <div className="d-flex justify-content-center">
      <h1>{children}</h1>
    </div>
  );
}

export default Heading;
