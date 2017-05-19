// Agent manager in project ier_hf.mas2j

/* Initial beliefs and rules */

/* Initial goals */

/* Plans */

+log_in <- decision.
+denied <- .print("Authentication failed").
+let_in <- .print("Authentication successful."); show_buttons.
+log_out <- .print("GoodBye!").
+wrong_id <- .print("Wrong format!").
