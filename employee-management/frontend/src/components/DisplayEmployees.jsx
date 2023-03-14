import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";

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

  return (
    <>
      <div className="container mx-auto my-8">
        <div className="h-12">
          <button
            onClick={() => navigate("/addEmployee")}
            className="rounded bg-blue-700 text-white px-6 py-2 font-bold hover:bg-slate-600"
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
                  Email ID Name
                </th>
                <th className="text-right font-bold text-gray-800 uppercase tracking-wider py-3 px-6">
                  Actions
                </th>
              </tr>
            </thead>
            {!loading && (
              <tbody>
                {employees.map((employee) => (
                  <tr key={employee.id}>
                    <td className="text-left px-6 py-4 whitespace-normal">
                      <div className="text-md text-gray-700">
                        {employee.firstName}
                      </div>
                    </td>
                    <td className="text-left px-6 py-4 whitespace-normal">
                      <div className="text-md text-gray-700">
                        {employee.lastName}
                      </div>
                    </td>
                    <td className="text-left px-6 py-4 whitespace-normal">
                      <div className="text-md text-gray-700">
                        {employee.emailId}
                      </div>
                    </td>
                    <td className="text-right px-6 py-4 whitespace-normal font-bold">
                      <a
                        href="#"
                        className="text-yellow-600 hover:text-indigo-800 px-4"
                      >
                        Update
                      </a>
                      <a
                        href="#"
                        className="text-red-600 hover:text-indigo-800"
                      >
                        Delete
                      </a>
                    </td>
                  </tr>
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