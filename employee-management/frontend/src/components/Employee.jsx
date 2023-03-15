import React from "react";

const Employee = ({ employee }) => {
  return (
    <tr key={employee.id}>
      <td className="text-left px-6 py-4 whitespace-normal">
        <div className="text-md text-gray-700">{employee.firstName}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-normal">
        <div className="text-md text-gray-700">{employee.lastName}</div>
      </td>
      <td className="text-left px-6 py-4 whitespace-normal">
        <div className="text-md text-gray-700">{employee.emailId}</div>
      </td>
      <td className="text-right px-6 py-4 whitespace-normal font-bold">
        <a href="#" className="text-yellow-600 hover:text-indigo-800 px-4">
          Update
        </a>
        <a href="#" className="text-red-600 hover:text-indigo-800">
          Delete
        </a>
      </td>
    </tr>
  );
};

export default Employee;
