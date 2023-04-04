function generateEmail(input, force) {
    if (input.isVisitor && !force) {
        return undefined;
    }
    else {
        return "".concat(input.firstName, ".").concat(input.lastName, "@test.org");
    }
}
function isPerson(potentialPerson) {
    if ("firstName" in potentialPerson && "lastName" in potentialPerson) {
        return true;
    }
    else {
        return false;
    }
}
function printEmailIfPerson(potentialPerson) {
    if (isPerson(potentialPerson)) {
        console.log("The information provided is a person & here is the email: " +
            generateEmail(potentialPerson));
    }
    else {
        console.log("Is not a valid person!");
    }
}
printEmailIfPerson({
    firstName: "test",
    lastName: "testing",
});
