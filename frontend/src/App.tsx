import "bootstrap/dist/css/bootstrap.css";
import { BrowserRouter, Routes, Route, Outlet } from "react-router-dom";
import NoPage from "./pages/NoPage";
import Home from "./pages/Customer/Home";
import Contact from "./pages/Customer/Contact";
import SignIn from "./pages/SignIn/SignIn";
import Detail from "./pages/Customer/Detail";
import Customers from "./pages/Admin/Customers";
import Vehicles from "./pages/Admin/Vehicles";
import AdminDetail from "./pages/Admin/LayoutDetails";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route index element={<Home />} />
        <Route path="home" element={<Home />} />
        <Route path="contact" element={<Contact />} />
        <Route path="signin" element={<SignIn />} />
        <Route path="detail" element={<Detail />} />
        <Route path="admin/customer" element={<Customers />} />
        <Route path="admin/vehicle" element={<Vehicles />} />
        <Route path="admin/detail" element={<AdminDetail />} />
        <Route path="*" element={<NoPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
