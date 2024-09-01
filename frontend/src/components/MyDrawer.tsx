import {
  Box,
  Button,
  Drawer,
  List,
  ListItem,
  ListItemButton,
  ListItemText,
} from "@mui/material";
import React from "react";
import { useNavigate } from "react-router-dom"; // Import useNavigate

function MyDrawer() {
  const [open, setOpen] = React.useState(false);
  const navigate = useNavigate(); // Initialize useNavigate

  const toggleDrawer = (newOpen: boolean) => () => {
    setOpen(newOpen);
  };

  const handleNavigation = (path: string) => {
    navigate(path);
    setOpen(false); // Close the drawer after navigation
  };

  const DrawerList = (
    <Box sx={{ width: 250 }} role="presentation" onClick={toggleDrawer(false)}>
      <h3 className="mt-4 mb-2 text-center">Smart Garage V2</h3>
      <List>
        {[
          { text: "Visits", path: "/admin/visit" },
          { text: "Customers", path: "/admin/customer" },
          { text: "Vehicles", path: "/admin/vehicle" },
          { text: "Services", path: "/admin/service" },
          { text: "Mechanics", path: "/admin/mechanic" },
          { text: "Developer API", path: "/admin/api" },
          { text: "Log Out", path: "/logout" },
        ].map((item, index) => (
          <ListItem key={item.text} disablePadding>
            <ListItemButton onClick={() => handleNavigation(item.path)}>
              <ListItemText primary={item.text} />
            </ListItemButton>
          </ListItem>
        ))}
      </List>
    </Box>
  );

  return (
    <div>
      <Button onClick={toggleDrawer(true)}>
        <span className="material-symbols-outlined">menu</span>
      </Button>
      <Drawer open={open} onClose={toggleDrawer(false)}>
        {DrawerList}
      </Drawer>
    </div>
  );
}

export default MyDrawer;
