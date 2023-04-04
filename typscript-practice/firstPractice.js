function generateEmail(input) {
    return "".concat(input.firstName, ".").concat(input.lastName, "@test.org");
}
console.log(generateEmail({
    firstName: "Jonathan",
    lastName: "Smith",
}));
