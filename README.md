# SOLID Payments

A small Java 21 study project that shows each of the five SOLID principles in a
payments domain (Pix, boleto, credit card).

Every principle has two packages:

- `before` — code that **violates** the principle, with comments explaining the problem.
- `after` — the same feature **refactored** to follow the principle.

Each package has tests whose names start with `BEFORE:` or `AFTER:`. The tests
are the best place to start reading: they show the pain and then the relief.

## How to run

Requirements: JDK 21 and Maven 3.9+.

```bash
mvn test
```

Or open the folder in IntelliJ IDEA and run the tests from `src/test/java`.

## Suggested study order

Study one principle per session. For each one:

1. Read the `before` test, then the `before` code. Ask yourself: "what hurts here?"
2. Read the `after` code and its test. Ask: "what changed, and what did it fix?"
3. Do the exercise from the table below without looking at anything else.

| Principle | One-sentence idea | Package | Exercise |
|-----------|-------------------|---------|----------|
| **S**RP — Single Responsibility | A class should have only one reason to change. | `srp` | Add SMS notification. Which `after` class changes? How many in `before`? |
| **O**CP — Open/Closed | Add behavior by adding code, not by editing working code. | `ocp` | Add a `PAYPAL` fee of 4.5% without touching `ocp.after.FeeCalculator`. |
| **L**SP — Liskov Substitution | A subtype must keep every promise of its parent type. | `lsp` | Uncomment the boleto line in `lsp.after.RefundServiceTest` and read the compiler error. |
| **I**SP — Interface Segregation | Clients should not depend on methods they do not use. | `isp` | Create a `CreditCardGateway` that can charge and refund, but has no Pix or boleto methods. |
| **D**IP — Dependency Inversion | Business rules depend on abstractions; details plug in from outside. | `dip` | Create a `SmsNotificationSender` and use it in `CheckoutService` without editing it. |

## How the principles connect

- **SRP** splits a class by responsibility.
- **OCP** uses an interface (Strategy pattern) so new behavior is a new class.
- **LSP** makes sure every implementation of that interface is trustworthy.
- **ISP** keeps those interfaces small, so implementations never fake methods.
- **DIP** makes high-level code receive those interfaces through the constructor,
  which is exactly what Spring does with constructor injection.

## Project structure

```
src/main/java/com/solidpayments
├── srp/{before,after}
├── ocp/{before,after}
├── lsp/{before,after}
├── isp/{before,after}
└── dip/{before,after}
    └── after/infrastructure   # MySQL, SMTP and in-memory implementations
```
