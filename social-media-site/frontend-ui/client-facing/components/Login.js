import { signIn } from "next-auth/react";
import React from "react";
import Image from "next/image";

const Login = () => {
  return (
    <div className="flex flex-col items-center mx-auto">
      <Image
        src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcFHBKrUJM-PTFSulR0tzIj8A7clXfMIElbUmqjvCsudFo53dZNXiZOI4qqsdD7gHuIWY&usqp=CAU"
        height={150}
        width={150}
      />
      <a
        onClick={signIn}
        className="px-20 py-4 z-10 text-2xl cursor-pointer 
      -mt-16 bg-yellow-300 rounded-md text-black"
      >
        Login
      </a>
    </div>
  );
};

export default Login;
