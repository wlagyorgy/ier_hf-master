// Agent manager in project ier_hf.mas2j

/* Initial beliefs and rules */

/* Initial goals */

/* Plans */

+user_in <- .decision.
+refresh <- .print("Data saved.").
+let_in <- .print("Authentication successful."); show_buttons.
+denied <- .print("Authentication failed").
