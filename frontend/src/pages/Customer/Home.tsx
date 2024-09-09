import Heading from "../../components/Heading";
import Layout from "../Layout";
import Table from "../../components/Table";
import FilterSection from "../../components/FilterSection";
import { useEffect, useState } from "react";
import Input from "../../components/Input";

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

export interface Vehicle {
  id: number;
  userId: number;
  model: string;
  licensePlate: string;
  vin: string;
  creationYear: number;
}

function Home() {
  const [isUserLoading, setIsUserLoading] = useState(false);
  const [user, setUser] = useState<User>();

  const columns = ["licensePlate", "model", "creationYear", "vin", "price"];

  const [visits, setVehicles] = useState<Vehicle | undefined>();
  const [areVisitsLoading, setAreVisitsLoading] = useState(false);

  const selectValues = ["All", "A5077HH", "CA1234AA"];

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

  useEffect(() => {
    const fetchVisits = async () => {
      setAreVisitsLoading(true);

      try {
        const response = await fetch(`${BASE_URL}/vehicle/1`);

        await new Promise((resolve) => setTimeout(resolve, 1400));

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
            <div className="row g-3 mb-5">
              <Input
                label="First Name"
                id="firstName"
                width={6}
                value={user?.firstName}
                disabled={true}
              />

              <Input
                label="Last Name"
                id="lastName"
                width={6}
                value={user?.lastName}
                disabled={true}
              />

              <Input
                label="Email"
                id="email"
                width={6}
                value={user?.email}
                disabled={true}
              />

              <Input
                label="Phone Number"
                id="phoneNumber"
                width={6}
                value={user?.phoneNumber}
                disabled={true}
              />
            </div>
          )}
        </div>
      </div>

      <Heading>Visits</Heading>
      {areVisitsLoading ? (
        <div className="d-flex justify-content-center my-4">
          <div className="spinner-border text-primary" role="status">
            <span className="visually-hidden">Loading...</span>
          </div>
        </div>
      ) : (
        <>
          <FilterSection
            elements={selectValues}
            selectLabel={"License Plates: "}
            showDates={true}
          />
          <div className="ms-5 me-5 mb-5">
            <Table columns={columns} data={visits ? [visits] : []} />
          </div>
        </>
      )}
    </Layout>
  );
}

export default Home;
