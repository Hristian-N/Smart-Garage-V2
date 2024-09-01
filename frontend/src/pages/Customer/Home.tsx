import Heading from "../../components/Heading";
import Layout from "../Layout";
import Table from "../../components/Table";
import FilterSection from "../../components/FilterSection";
import { useEffect, useState } from "react";

const BASE_URL = "http://localhost:8080";

export interface User {
  id: number;
  vehicles: Vehicle[];
  firstName: string;
  lastName: string;
  password: string;
  email: string;
  phoneNumber: string;
  isDeleted: boolean;
  isAdmin: boolean;
  isMechanic: boolean;
}

interface Vehicle {
  id: number;
  userId: number;
  model: string;
  licensePlate: string;
  vin: string;
  creationYear: number;
}

function Visits() {
  /*
  const columns = [
    "License Plate",
    "Brand",
    "Model",
    "Date",
    "Price",
    "Details",
  ];
  */

  const columns = ["licensePlate", "model", "creationYear", "vin", "price"];

  const [vehicle, setVehicles] = useState<Vehicle | undefined>();
  const [areVisitsLoading, setAreVisitsLoading] = useState(false);

  const selectValues = ["All", "A5077HH", "CA1234AA"];

  useEffect(() => {
    const fetchVisits = async () => {
      setAreVisitsLoading(true);

      try {
        const response = await fetch(`${BASE_URL}/vehicle/1`);

        await new Promise((resolve) => setTimeout(resolve, 1000));

        if (!response.ok) {
          throw new Error(`Error: ${response.status} ${response.statusText}`);
        }

        const visitData = (await response.json()) as Vehicle;
        setVehicles(visitData);
        setAreVisitsLoading(false);
      } catch (error) {
        console.error("Failed to fetch visits:", error);
        setAreVisitsLoading(false);
      }
    };

    fetchVisits();
  }, []);

  return (
    <div className="mt-5">
      <Heading>Visits</Heading>
      <FilterSection
        elements={selectValues}
        selectLabel={"License Plates: "}
        showDates={true}
      />
      <div className="ms-5 me-5 mb-5">
        <Table columns={columns} data={vehicle ? [vehicle] : []} />
      </div>
    </div>
  );
}

function Home() {
  const [isUserLoading, setIsUserLoading] = useState(false);
  const [user, setUser] = useState<User>();

  useEffect(() => {
    const fetchUser = async () => {
      setIsUserLoading(true);

      try {
        const response = await fetch(`${BASE_URL}/user/1`);

        await new Promise((resolve) => setTimeout(resolve, 1000));

        if (!response.ok) {
          throw new Error(`Error: ${response.status} ${response.statusText}`);
        }

        const userData = (await response.json()) as User;
        setUser(userData);
        setIsUserLoading(false);
      } catch (error) {
        console.error("Failed to fetch user:", error);
        setIsUserLoading(false);
      }
    };

    fetchUser();
  }, []);

  return (
    <Layout>
      <div className="d-flex align-items-center justify-content-center">
        <Heading>Personal Information</Heading>
        <button type="button" className="btn btn-icon">
          <span className="material-symbols-outlined">settings</span>
        </button>
      </div>

      <div className="d-flex justify-content-center">
        <div className="col-md-7 col-lg-8">
          {isUserLoading ? (
            <div className="d-flex justify-content-center my-4">
              <div className="spinner-border text-primary" role="status">
                <span className="visually-hidden">Loading...</span>
              </div>
            </div>
          ) : (
            <div className="row g-3">
              <div className="col-sm-6">
                <label htmlFor="firstName" className="form-label">
                  First name
                </label>
                <input
                  type="text"
                  className="form-control"
                  id="firstName"
                  value={user?.firstName || ""}
                  disabled
                />
              </div>

              <div className="col-sm-6">
                <label htmlFor="lastName" className="form-label">
                  Last name
                </label>
                <input
                  type="text"
                  className="form-control"
                  id="lastName"
                  value={user?.lastName || ""}
                  disabled
                />
              </div>

              <div className="col-6">
                <label htmlFor="email" className="form-label">
                  Email
                </label>
                <input
                  type="email"
                  className="form-control"
                  id="email"
                  value={user?.email || ""}
                  disabled
                />
              </div>

              <div className="col-6">
                <label htmlFor="phoneNumber" className="form-label">
                  Phone Number
                </label>
                <input
                  type="text"
                  className="form-control"
                  id="phoneNumber"
                  value={user?.phoneNumber || ""}
                  disabled
                />
              </div>
            </div>
          )}
        </div>
      </div>

      <Visits />
    </Layout>
  );
}

export default Home;
