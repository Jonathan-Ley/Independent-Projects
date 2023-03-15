import "./App.css";
import AddEmployee from "./components/AddEmployee";
import NavBar from "./components/NavBar";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import DisplayEmployees from "./components/DisplayEmployees";
import UpdateEmployee from "./components/UpdateEmployee";

function App() {
  return (
    <>
      <BrowserRouter>
        <NavBar />
        <Routes>
          <Route index element={<DisplayEmployees />} />
          <Route path="/" element={<DisplayEmployees />} />
          <Route path="/employeeList" element={<DisplayEmployees />} />
          <Route path="/addEmployee" element={<AddEmployee />} />
          <Route path="/editEmployee/:id" element={<UpdateEmployee />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
