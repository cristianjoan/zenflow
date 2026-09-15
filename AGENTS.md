\# Zenflow project instructions



Zenflow is an Android/Kotlin application.



Always follow the user's explicit task exactly.



Do not invent, reinterpret, or substitute the requested task with another task.



Before making changes:

\- Inspect the existing implementation.

\- Verify files and components in the repository.

\- Read any specification or implementation-plan files explicitly provided by the user.



When the user provides a design specification:

\- Treat it as the visual source of truth.

\- Implement the requested design.

\- Do not replace it with your own interpretation.



When the user provides an implementation plan:

\- Use it to understand the existing architecture and locate the relevant code.

\- Do not expand the scope beyond the user's request.



Scope rules:

\- Modify only files required for the requested task.

\- Do not modify unrelated features.

\- Do not fix unrelated bugs or tests.

\- Do not make unrelated refactors.

\- Do not modify Gradle or configuration files unless the requested task strictly requires it.

\- Do not hardcode placeholder content from screenshots when the real application already provides dynamic data.



If a file mentioned in a specification does not exist:

\- Search the repository for the actual implementation.

\- Continue the requested task.

\- Do not reinterpret the task because of the mismatch.



For UI work:

\- Preserve existing ViewModels, repositories, navigation, and data flow unless the user explicitly requests changes.

\- Reuse existing components where practical.

\- Implement the requested UI instead of merely describing it.



When the user asks for implementation:

\- Implement it.

\- Do not stop after analysis.

\- Do not ask what should be implemented when the user already specified it.



If an unrelated problem is discovered:

\- Leave it alone.

\- Continue with the requested task.



After implementation:

\- Build or compile the affected code.

\- Fix only errors caused by the requested changes.

\- Report the files modified and the build result.

