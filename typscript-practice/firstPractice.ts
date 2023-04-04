interface Person {
  firstName: string;
  lastName: string;
  job?: job; //the ? allows optional parameter if wanted
  isVisitor?: boolean;
}

type job = "Engineer" | "Programmer";

function generateEmail(input: Person, force?: boolean): string | undefined {
  if (input.isVisitor && !force) {
    return undefined;
  } else {
    return `${input.firstName}.${input.lastName}@test.org`;
  }
}

console.log(
  generateEmail({
    firstName: "Jonathan",
    lastName: "Smith",
    isVisitor: false,
  })
);
