import React from "react";
import { useNavigate } from "react-router-dom";

const DisplayEmployees = () => {
  const navigate = useNavigate();
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
            <tbody>
              <tr>
                <td className="text-left px-6 py-4 whitespace-normal">
                  <div className="text-md text-gray-700">Jonathan</div>
                </td>
                <td className="text-left px-6 py-4 whitespace-normal">
                  <div className="text-md text-gray-700">Ley</div>
                </td>
                <td className="text-left px-6 py-4 whitespace-normal">
                  <div className="text-md text-gray-700">
                    joley@teksystems.com
                  </div>
                </td>
                <td className="text-right px-6 py-4 whitespace-normal font-bold">
                  <a
                    href="#"
                    className="text-yellow-600 hover:text-indigo-800 px-4"
                  >
                    Update
                  </a>
                  <a href="#" className="text-red-600 hover:text-indigo-800">
                    Delete
                  </a>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
};

export default DisplayEmployees;
