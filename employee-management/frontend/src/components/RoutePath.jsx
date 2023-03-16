import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import AddEmployee from "./AddEmployee";
import NavBar from "./NavBar";
import DisplayEmployees from "./DisplayEmployees";
import UpdateEmployee from "./UpdateEmployee";
import Footer from "./Footer";
import ErrorPage from "./ErrorPage";

const RoutePath = () => {
  return (
    <BrowserRouter>
      <NavBar />
      <Routes>
        <Route index element={<DisplayEmployees />} />
        <Route path="/" element={<DisplayEmployees />} />
        <Route path="/employeeList" element={<DisplayEmployees />} />
        <Route path="/addEmployee" element={<AddEmployee />} />
        <Route path="/editEmployee/:id" element={<UpdateEmployee />} />
        <Route path="*" element={<ErrorPage />} />
      </Routes>
      <Footer />
    </BrowserRouter>
  );
};

export default RoutePath;
