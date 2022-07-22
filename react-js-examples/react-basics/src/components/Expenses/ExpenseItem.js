import { useState } from "react";

import Card from "../UI/Card";
import "./ExpenseItem.css";


function ExpenseItem(expense) {
    const month = expense.date.toLocaleString("en-US", { month: "2-digit" });
    const date = expense.date.toLocaleString("en-US", { day: "2-digit" });
    const year = expense.date.getFullYear();

    const enteredTitle = expense.title;

    // const [ title, setTitle ] = useState(enteredTitle);

    const clickHandler = () => {
        // setTitle("updated");
        console.log("updated");
    }

    // console.log(`input title is ${enteredTitle}`);
    // console.log(`title is ${title}`);

    return (
        <Card className="expense-item">
            <div className="expense-date">
                {year}-{month}-{date}
            </div>
            <div className="expense-item__description">
                <h2>{enteredTitle}</h2>
                <div className="expense-item__price">£{expense.amount}</div>
            </div>
            <button onClick={clickHandler}>Change Title</button>
        </Card>
    );
}

export default ExpenseItem;