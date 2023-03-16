import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";
import Employee from "./Employee";

const DisplayEmployees = () => {
  const navigate = useNavigate();
  const [loading, setLoading] = useState(true); //used to handle loading & check if data is loaded
  const [employees, setEmployees] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await EmployeeService.getEmployees();
        setEmployees(response.data);
      } catch (error) {
        console.log(error);
      }
      setLoading(false);
    };
    fetchData();
  }, []);

  const deleteEmployee = (e, id) => {
    e.preventDefault();
    EmployeeService.deleteEmployee(id).then((res) => {
      if (employees) {
        setEmployees((previousEmployee) => {
          return previousEmployee.filter((employee) => employee.id !== id);
        });
      }
    });
  };

  return (
    <>
      <div className="container mx-auto my-8">
        <div className="h-12">
          <button
            onClick={() => navigate("/addEmployee")}
            className="rounded bg-emerald-700 text-white px-6 py-2 font-bold hover:bg-orange-600"
          >
            Add New Employee
          </button>
        </div>
        <div className="flex shadow border-b">
          <table className="min-w-full">
            <thead className="bg-gray-200">
              <tr>
                <th className="text-left font-bold text-gray-800 uppercase tracking-wider py-3 px-6">
                  First Name
                </th>
                <th className="text-left font-bold text-gray-800 uppercase tracking-wider py-3 px-6">
                  Last Name
                </th>
                <th className="text-left font-bold text-gray-800 uppercase tracking-wider py-3 px-6">
                  Email
                </th>
                <th className="text-right font-bold text-gray-800 uppercase tracking-wider py-3 px-6">
                  Actions
                </th>
              </tr>
            </thead>
            {!loading && (
              <tbody>
                {employees.map((employee) => (
                  <Employee
                    employee={employee}
                    deleteEmployee={deleteEmployee}
                    key={employee.id}
                  />
                ))}
              </tbody>
            )}
          </table>
        </div>
      </div>
    </>
  );
};

export default DisplayEmployees;
