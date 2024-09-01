import Header from "../components/Header";
import Footer from "../components/Footer";
import { ReactNode } from "react";

interface Props {
  children: ReactNode;
}

function Layout({ children }: Props) {
  const Title = "Smart-Garage-V2";
  const Tabs = ["Home", "Contact Us", "Logout"];
  const Links = ["/home", "/contact", "/logout"];

  return (
    <div className="d-flex flex-column min-vh-100">
      <Header tabs={Tabs} links={Links}>
        {Title}
      </Header>
      <main className="flex-shrink-0">{children}</main>
      <Footer tabs={Tabs} links={Links}>
        {Title}
      </Footer>
    </div>
  );
}

export default Layout;
