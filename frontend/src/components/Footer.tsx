import { Link } from "react-router-dom";

interface Props {
  children: string;
  tabs: string[];
  links: string[];
}

function Footer({ children, tabs, links }: Props) {
  return (
    <footer className="footer mt-auto py-3 bg-body-tertiary">
      <div className="container">
        <span className="text-body-secondary">
          <ul className="nav justify-content-center border-bottom pb-3 mb-3">
            {tabs.map((tab, index) => (
              <li className="nav-item" key={index}>
                <Link
                  to={links[index]}
                  className="nav-link px-2 text-body-secondary"
                >
                  {tab}
                </Link>
              </li>
            ))}
          </ul>
          <p className="text-center text-body-secondary">© 2024 {children}</p>
        </span>
      </div>
    </footer>
  );
}

export default Footer;
