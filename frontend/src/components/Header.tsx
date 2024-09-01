import { Link } from "react-router-dom";

interface Props {
  children: string;
  tabs: string[];
  links: string[];
}

function Header({ children, tabs, links }: Props) {
  return (
    <>
      <div className="container">
        <header className="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
          <a
            href="/"
            className="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none"
          >
            <span className="fs-4">{children}</span>
          </a>

          <ul className="nav nav-pills">
            {tabs.map((tab, index) => (
              <li className="nav-item" key={index}>
                <Link
                  to={links[index]}
                  className="nav-link"
                  aria-current="page"
                >
                  {tab}
                </Link>
              </li>
            ))}
          </ul>
        </header>
      </div>
    </>
  );
}

export default Header;
