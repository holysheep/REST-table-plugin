jQuery(function () {
    alert(1);
    var $table = AJS.$("#project-config-teams-table");

    function getResourceURL() {
        return contextPath + "/rest/teams/1.0/teams.json";
    }

    function getTeam(callback) {
        JIRA.SmartAjax.makeRequest({
            url: getResourceURL(),
            complete: function (xhr, status, response) {
                if (response.successful) {
                    callback(response.data.teams);
                } else {
                    $table.trigger("serverError",
                        [JIRA.SmartAjax.buildSimpleErrorContent(response)]);
                }
            }
        });
    }

    getTeam(function (teams) {
        window.t = teams;
        alert(JSON.stringify(teams));
        JIRA.Admin.TeamTable = new AJS.RestfulTable({
            el: $table,
            editable: true,
            url: getResourceURL(),
            entries: teams,
            resources: {
                all: getResourceURL(),
                self: getResourceURL()
            },
            columns: [
                {
                    id: "name",
                    header: "Name"
                },
                {
                    id: "created",
                    header: "Created"
                }
            ],
            noEntriesMsg: 'There are currently no teams',
            views: {
                editRow: JIRA.Admin.Team.EditTeamRow,
                row: JIRA.Admin.Team.TeamRow
            }
        });
        //jQuery(".jira-restfultable-init").remove();
        JIRA.userhover($table);
    });
});
