import React from "react";
import { useNavigate } from "react-router-dom";

const Employee = ({ employee, deleteEmployee }) => {
  const navigate = useNavigate();
  const updateEmployee = (e, id) => {
    e.preventDefault();
    navigate(`/editEmployee/${id}`);
  };

  return (
    <tr key={employee.id}>
      <td className="text-left px-6 py-4 whitespace-normal">
        <div className="text-md text-gray-700">{employee.firstName}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-normal">
        <div className="text-md text-gray-700">{employee.lastName}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-normal">
        <div className="text-md text-gray-700">{employee.email}</div>
      </td>
      <td className="text-right px-6 py-4 whitespace-normal font-bold">
        <a
          onClick={(e, id) => updateEmployee(e, employee.id)}
          value="update"
          className="text-yellow-600 hover:text-indigo-800 px-4 hover:cursor-pointer"
        >
          Update
        </a>
        <a
          onClick={(e, id) => deleteEmployee(e, employee.id)}
          className="text-red-600 hover:text-indigo-800 hover:cursor-pointer"
        >
          Delete
        </a>
      </td>
    </tr>
  );
};

export default Employee;
