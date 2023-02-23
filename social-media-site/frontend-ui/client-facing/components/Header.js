import Image from "next/image";
import React from "react";

const Header = () => {
  return (
    <div className="bg-white flex items-center p-2 shadow-md top-0 sticky z-50 h-16">
      {/* left component */}
      <div className="flex min-w-fit">
        <Image
          src="https://d3ui957tjb5bqd.cloudfront.net/uploads/2017/01/C-Bird-by-George-Bokhua.jpg"
          height={60}
          width={80}
        />
      </div>
      {/* center component */}
      {/* right component */}
    </div>
  );
};

export default Header;
