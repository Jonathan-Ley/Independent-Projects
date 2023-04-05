// interface Person {
//   firstName: string;
//   lastName: string;
//   job?: job; //the ? allows optional parameter if wanted
//   isVisitor?: boolean;
// }

type job = "Engineer" | "Programmer";

function generateEmail(input: Person, force?: boolean): string | undefined {
  if (input.isVisitor && !force) {
    return undefined;
  } else {
    return `${input.firstName}.${input.lastName}@test.org`;
  }
}

function isPerson(potentialPerson: any): boolean {
  if ("firstName" in potentialPerson && "lastName" in potentialPerson) {
    return true;
  } else {
    return false;
  }
}

function printEmailIfPerson(potentialPerson: any): void {
  if (isPerson(potentialPerson)) {
    console.log(
      "The information provided is a person & here is the email: " +
        generateEmail(potentialPerson)
    );
  } else {
    console.log("Is not a valid person!");
  }
}

printEmailIfPerson({
  firstName: "test",
  lastName: "testing",
});
